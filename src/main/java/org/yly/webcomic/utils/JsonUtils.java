package org.yly.webcomic.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yly.webcomic.vo.ComicUserVO;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonUtils  {

    public static Object parseObj(HttpServletRequest req,Class clazz){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = req.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object obj = mapper.readValue(sb.toString(), clazz);
            return obj;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
