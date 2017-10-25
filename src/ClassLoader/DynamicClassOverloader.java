package ClassLoader;
import java.io.*;

public class DynamicClassOverloader extends ClassLoader
{
    private java.util.Map classesHash= new java.util.HashMap();
    public final String[] classPath;
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public DynamicClassOverloader(String[] classPath)
    {
        // ����� ����� ������ - ������ ���������� CLASSPATH
        this.classPath= classPath;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    protected synchronized Class loadClass(String name,boolean resolve) throws ClassNotFoundException
    {
        Class result= findClass(name);
        if (resolve)
            resolveClass(result);
        return result;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    protected Class findClass(String name) throws ClassNotFoundException
    {
        Class result= (Class)classesHash.get(name);
        if (result!=null) {
            /*
             * System.out.println("% Class "+name+" found in cache");
            */
            return result;
        }
        
        File f= findFile(name.replace('.','/'),".class");
        // ����� mypackage.MyClass ������� ������ ����� mypackage/MyClass.class
        /*
         * System.out.println("% Class "+name+(f==null?"":" found in "+f));
        */
        if (f==null) {
             // ���������� � ���������� ���������� � ������ �������. findSystemClass � ��� ����� ������������ ������
             // ClassLoader � ����������� protected final Class findSystemClass(String name) (�.�. ���������������
             // ��� ������������� � ����������� � �� ���������� ���������������). �� ��������� ����� � �������� ������
             // �� ��������� ���������� ����������. ��� ������ findSystemClass(name) ��� �������� �� ��������������
             // ������������ � �������� ���� ����������� ������������ ������� ���� java.lang.String, ��� ����������� ��
             // ����������� ������ � JAR-�������� (����������� ���������� ����� ������ ��������� � JAR)
             return findSystemClass(name);
        }

        try {
            byte[] classBytes= loadFileAsBytes(f);
            result= defineClass(name,classBytes,0,classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class "+name+": "+e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format of class file incorrect for class "+name+": "+e);
        }

        classesHash.put(name,result);
        return result;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    protected java.net.URL findResource(String name)
    {
        File f= findFile(name, "");
        if (f==null) 
            return null;
        try {
            return f.toURL();
        } catch(java.net.MalformedURLException e) {
            return null;
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * ����� ����� � ������ name �, ��������, ����������� extension � ��������� ������, �������� ����������
     * ������������ classPath. ����� ������������ � name ����������� �������� '/' � ���� ���� � ������������
     * ������� ������ ������ ����������� ��� ������������. (������ � ����� ���� �������� ���� �������� �����
     * findResource.)
     */
    private File findFile(String name, String extension)
    {
        for (int k=0; k <classPath.length; k++) {
            File f= new File((new File(classPath[k])).getPath() +
                                  File.separatorChar + name.replace('/',File.separatorChar) + extension);
            if (f.exists()) 
                return f;
        }
        return null;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static byte[] loadFileAsBytes(File file) throws IOException
    {
        byte[] result = new byte[(int)file.length()];
        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result,0,result.length);
        } finally {
            try {
               f.close();
            } catch (Exception e) {
               // ���������� ����������, ��������� ��� ������ close. ��� ������ ������������ � �� �����
               // ����� - ���� ��� ��������. �� ���� ��� ��� �� ���������, �� ��� �� ������ �������������
               // ������������� ������ ������, ��������� ��� ������ read.
            };
        }
        return result;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
