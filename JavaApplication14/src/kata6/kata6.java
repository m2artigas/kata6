/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.xml.bind.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static java.util.stream.Collectors.joining;


public class kata6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {

        URL url = new URL("https://dummyjson.com/todos");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(read(url), JsonObject.class)
                .get("todos").getAsJsonArray()
                .get(0).getAsJsonObject(); //obtiene un elementos

        ToDo todo = gson.fromJson(jsonObject, ToDo.class);
        System.out.println(todo.toString());

        JAXBContext context = JAXBContext.newInstance(ToDo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(todo, System.out);

        
    }

    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }           
    }
    
}
