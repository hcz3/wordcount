import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by hczhang on 12/03/15.
 */

public class test {
    public static String getURLContent(String urlString, String encoding) {
        String line;
        StringBuffer content = new StringBuffer();
        try {

            URL url = new URL(urlString);

            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        catch (MalformedURLException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return content.toString();
    }

    public static void subCounter(String str1, String str2) {
        int counter = 0;
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str1.substring(i, i + str2.length()).equalsIgnoreCase(str2)) {
                counter++;
            }
        }
        System.out.println("The number of "+str2+" is " + counter);

    }

    public static String outTag(String s) {
        s = s.replaceAll("<script[\\s\\S]*?</script>", "");
        //s = s.replaceAll("display:none[\\s\\S]*?>[\\s\\S]*?<[\\s\\S]*?>", "");
        //s = s.replaceAll("<tr style=\"display: none;\">[\\s\\S]*?</tr>", "");
        s = s.replaceAll("class=\"printfooter\"[\\s\\S]*?</div>", "");

        s = s.replaceAll("<.*?>", "");

        return s;
    }

    public static void main(String[] args) {
        String content;
        //String url = "http://baike.baidu.com/subview/29/12654100.htm";
        int start;
        int end;
        //String url="http://en.wikipedia.org/wiki/Java_(programming_language) ";
        content = getURLContent(args[0], "gb2312");

        //System.out.println(content);
        start = content.indexOf("<body");
        end = content.indexOf("</body");
        System.out.println(start);
        System.out.println(end);
        content = content.substring(start, end);
        content = outTag(content);
        //System.out.println(content);
        subCounter(content, args[1]);
    }
}



//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;


//public class test {
//
//    public static void main(String[] args){
//
//        acquireData("http://en.wikipedia.org/wiki/Java_(programming_language)","java");
//
//// Command line version
////        if(args.length!=2){
////            System.out.print("java test.class "+"http://en.wikipedia.org/wiki/Java_(programming_language) "+" java");
////
////        }
////        String url = args[0];
////        String t = args[1];
////        acquireData(url,t);
//
//    }
//
//    public static void acquireData(String url, String words){
//
//        try{
//
////            Document doc = Jsoup.connect(url).get();
//            Document doc = Jsoup.connect(url).timeout(50000).get();
//            Elements con = doc.getElementsByTag("body");
////            System.out.println(con.text());
//
//            String context = con.text();
//
//
//            int count = 0;
//            char[] ws =  words.toLowerCase().toCharArray();
//            int lenw = ws.length;
//            int [] wc = new int[lenw + 1];
//            wc[0] = -1;
//            int i = 0;
//            int j = -1;
//
//            while(i<lenw){
//                if(j == -1 || ws[i] == ws[j]){
//                    wc[++i] = ++j;
//                }
//                else
//                {
//                    j = wc[j];
//                }
//
//            }
//
//
//            char[] cs = context.toLowerCase().toCharArray();
//            int lenc = cs.length;
//            i = 0;j = 0;
//            while(i<lenc){
//                if(j == -1||cs[i] == ws[j])
//                {
//                    i++;
//                    j++;
//                }
//                else
//                {
//                    j = wc[j];
//                }
//                if(j == lenw)
//                {
//                    count++;
//                    j=0;
//                }
//
//            }
//            System.out.println(count);
//
//            String css = context.toLowerCase();
//            String wss = words.toLowerCase();
//
//            int ii = css.indexOf(wss);
//            int ans = 0;
//            while(ii != -1){
//                ans++;
//                ii = css.indexOf(wss,ii + lenw);
//            }
//            System.out.println(ans);
//
//
//        }catch(Exception e){
//            e.printStackTrace();
//
//        }
//
//
//    }
//
//}


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