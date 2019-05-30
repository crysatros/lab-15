public class Main {
    private static String srcFile;
    private static String dstFile;
    private static int buffSize;

    public static void main(String[] args) {
        for(String str: args){
            String[] key_val = str.split("=");

            if(key_val[0].compareTo("--srcpath") == 0)
                srcFile = key_val[1];

            if(key_val[0].compareTo("--dstpath") == 0)
                dstFile = key_val[1];

            if(key_val[0].compareTo("--size") == 0)
                buffSize = Integer.parseInt(key_val[1]);

        }

        CopyTXT copy = new CopyTXT();

        double time = copy.copy(srcFile, dstFile, buffSize);
        System.out.println("File copy time: " + time + " seconds");


    }
}
