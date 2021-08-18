public class HelloWorld {

    public static void main(String[] args) {
//        String str = "hello";
//        int age = 18;

        String key = "server.3=zoo3:2888:3888";
        //server.3=zoo3:2888:3888
        if (key.startsWith("server.")) {
            int dot = key.indexOf('.');
            long sid = Long.parseLong(key.substring(dot + 1));

            System.out.println("sid=" + sid);


        }
    }

}
