package validators;

import constants.Constants;
import java.io.File;

/**
 * @author Nataly Haievska
 * @date 01.06.2020
 */

public class CheckBase {
    public static boolean isExists(){
        String filePath = Constants.DB_BASE_URL + Constants.DB_NAME;
        File dbFile = new File(filePath);
        return dbFile.exists();
    }
}
