package dictionary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class DictionaryServlet {

   ScrabbleDictionary dictionary;


    public DictionaryServlet() throws IOException {
        dictionary = new ScrabbleDictionary();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();


        String word = request.getParameter("word");
        if(dictionary.contains(word))
        {
            out.println(dictionary.getDefinition(word));
        }
        else {
            out.println("Word not found");
        }
    }

}

