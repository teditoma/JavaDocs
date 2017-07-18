package ro.teamnet.zth.web;

import model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import model.Person;

/**
 * TODO Write javadoc
 */
@MultipartConfig
public class ImportFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 1: Obtain the username from the request instance
        String user = request.getParameter("user");

        // Obtain the File object from the request instance
        Part file = request.getPart("uploadFile");

        // read the lines from CSV file and print the values
        // TODO 2: Replace T with Person
        List<Person> personFromFile = readLines(file);

        // Set the response type
        response.setContentType("text/html");

        // TODO 6: Print a nice message to the response so the user will be notified of the result
        // TIP: The final text printed on the response should be something like this: "Hello <username>! You successfully imported 4 people. "
        response.getWriter().write("File uploaded!");

    }

    /**
     * TODO write javadoc
     * @param file
     * @return
     */
    private List<Person> readLines(Part file) {
        List<Person> persons = new ArrayList<>();

        // TODO 3: Replace with try-with-resources
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));){
            // TODO 4: Iterate through the lines of the reader using java streams.
            // TIP: Use map to get the current line
            // TIP: Use split() method for each line (check API documentation)
            // TIP: For Long and Boolean fields you should use valueOf() method
            // TIP: Use Collectors to return a List

            persons = bufferedReader.lines().map(x->{
                String[] splitLine = x.split(",");
                return new Person(splitLine[0],
                        splitLine[1],
                        Long.valueOf(splitLine[2]),
                        Boolean.valueOf(splitLine[3]));
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }


        // after implementing the list, let's print it. It will print nicely if you have overridden the toString() method ;)
        persons.forEach(System.out :: println);

//        TODO 5: Sort the persons list by their age field
        // TIP: use lambda expression (only one line of code is needed to complete this step)
        persons.sort((a,b)->a.getAge()>b.getAge()?1:0);

        // let's print again to check if it's sorted
        persons.forEach(System.out :: println);

        return persons;
    }

    private class T {
    }
}
