import java.io.BufferedReader;
import java.io.IOException;
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

    public static int subCounter(String str1, String str2) {
        int counter = 0;
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str1.substring(i, i + str2.length()).equalsIgnoreCase(str2)) {
                counter++;
            }
        }
        return counter;

    }

    public static String outTag(String s) {
        s = s.replaceAll("<script[\\s\\S]*?</script>", "");

        // try to judge the display tag but not work
        //s = s.replaceAll("display:none[\\s\\S]*?>[\\s\\S]*?<[\\s\\S]*?>", "");
        //s = s.replaceAll("<tr style=\"display: none;\">[\\s\\S]*?</tr>", "");
        s = s.replaceAll("class=\"printfooter\"[\\s\\S]*?</div>", "");

        s = s.replaceAll("<.*?>", "");

        return s;
    }

    public static void main(String[] args) {

        String asciiRegex = "^\\p{Alpha}+$";
        if(!args[1].matches(asciiRegex)) {
            System.out.println("The searched keywords should be an English word");
            System.exit(0);
        }
        String content;
        int start;
        int end;
        content = getURLContent(args[0], "gb2312");

        //System.out.println(content);
        start = content.indexOf("<body");
        end = content.indexOf("</body");
        System.out.println(start);
        System.out.println(end);
        content = content.substring(start, end);
        content = outTag(content);
        //System.out.println(content);
        System.out.println("The number of "+args[1]+" is "+subCounter(content, args[1]));
    }
}



