package personal.jain.akash.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

public class TestDataReader extends Properties{

	private static final long serialVersionUID = -1159950412857912109L;
	private static TestDataReader INSTANCE;
	private static final Object LOCK = new Object();
	
	private TestDataReader() throws IOException {
		super();
		FileInputStream testDataFileIS = 
				new FileInputStream(fetchFile("test-data.properties"));
		load(testDataFileIS);
		testDataFileIS.close();
	}
	
	public static TestDataReader getInstance() throws IOException {
		if(INSTANCE != null) {
			return INSTANCE;			
		}

		synchronized (LOCK) {
			if(INSTANCE == null) {
				INSTANCE = new TestDataReader();
			}
			return INSTANCE;
		}
	}
	
	private static File fetchFile(String in_filePath) {
        URL l_resourceUrl = Thread.currentThread().getContextClassLoader()
                .getResource(in_filePath);
        
        if (l_resourceUrl == null) {
            return new File(in_filePath);
        }
        
        try {
            l_resourceUrl = decodeURLPath(l_resourceUrl);
        } catch (MalformedURLException e) {
        }

        

        return new File(l_resourceUrl.getFile());
    }
	
	private static String decodeURLPath(String in_string) {
        String lr_decodedString = "";
        try {
            lr_decodedString = URLDecoder.decode(in_string, "UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
        return lr_decodedString;
    }

	private static URL decodeURLPath(URL in_url) throws MalformedURLException {
        
        return new URL(decodeURLPath(in_url.toString()));
    }
}
