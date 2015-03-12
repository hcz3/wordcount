import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by hczhang on 12/03/15.
 */


public class test {

    public static void main(String[] args){

        acquireData("http://en.wikipedia.org/wiki/Java_(programming_language)","java");

// Command line version
//        if(args.length!=2){
//            System.out.print("java test.class "+"http://en.wikipedia.org/wiki/Java_(programming_language) "+" java");
//
//        }
//        String url = args[0];
//        String t = args[1];
//        acquireData(url,t);

    }

    public static void acquireData(String url, String words){

        try{

//            Document doc = Jsoup.connect(url).get();
            Document doc = Jsoup.connect(url).timeout(50000).get();
            Elements con = doc.getElementsByTag("body");
//            System.out.println(con.text());

            String context = con.text();


            int count = 0;
            char[] ws =  words.toLowerCase().toCharArray();
            int lenw = ws.length;
            int [] wc = new int[lenw + 1];
            wc[0] = -1;
            int i = 0;
            int j = -1;

            while(i<lenw){
                if(j == -1 || ws[i] == ws[j]){
                    wc[++i] = ++j;
                }
                else
                {
                    j = wc[j];
                }

            }


            char[] cs = context.toLowerCase().toCharArray();
            int lenc = cs.length;
            i = 0;j = 0;
            while(i<lenc){
                if(j == -1||cs[i] == ws[j])
                {
                    i++;
                    j++;
                }
                else
                {
                    j = wc[j];
                }
                if(j == lenw)
                {
                    count++;
                    j=0;
                }

            }
            System.out.println(count);

            String css = context.toLowerCase();
            String wss = words.toLowerCase();

            int ii = css.indexOf(wss);
            int ans = 0;
            while(ii != -1){
                ans++;
                ii = css.indexOf(wss,ii + lenw);
            }
            System.out.println(ans);


        }catch(Exception e){
            e.printStackTrace();

        }


    }

}


//class test {
//    private static int num = 0;
//    public void run() throws IOException {
//
//        FileReader f = new FileReader("/Users/hczhang/Desktop/data.txt");
//        BufferedReader br = new BufferedReader(f);
//        String line = null;
//        while((line = br.readLine())!=null)
//        {
//            String[] ss = line.split("\\W+");
//            for(String e:ss)
//                if(e.contentEquals("Java")) num++;
//        }
//        System.out.println("\"Java\" is: "+num);
//        f.close();
//    }
//
//    public static void main(String[] args) throws IOException
//    {
//        test w = new test();
//        w.run();
//    }
//
//}





//public class test
//{
//    public void read()
//    {
//        String s1="(J|j)ava";
//        String s2="[^a-z]";
//        int i=0;
//        try{
//            BufferedReader br=new BufferedReader(new FileReader("/Users/hczhang/Desktop/data.txt"));
//            while(br.read()!=-1)
//            {
//                String []sto=br.readLine().split(s2);
//                for(String e:sto)
//                {
//                    if(e.matches(s1))
//                        i++;
//                }
//            }
//        }catch(Exception e){}
//        System.out.println(i);
//    }
//
//    public static void main(String []args)
//    {
//        new test().read();
//    }
//}