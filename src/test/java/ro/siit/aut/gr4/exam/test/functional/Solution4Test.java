package ro.siit.aut.gr4.exam.test.functional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.aut.gr4.exam.test.model.AccountModel;
import ro.siit.aut.gr4.exam.test.model.FileAndAccountModel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Solution4Test extends BaseTest {

    private File[] files = getListOfFiles("json");

    private List<FileAndAccountModel> getListOfAccountModelsFromJsonFiles() {
        List<FileAndAccountModel> fileAndAccountModelList = new ArrayList<>();
        FileAndAccountModel fileAndAccountModel = null;
        AccountModel accountModel = null;
        ObjectMapper mapper = new ObjectMapper();

        for (File f : files) {
            try {
                accountModel = mapper.readValue(f, AccountModel.class);
                fileAndAccountModel = new FileAndAccountModel(accountModel, f.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileAndAccountModelList.add(fileAndAccountModel);
        }

        return fileAndAccountModelList;
    }

    @Test
    public Solution4Test() throws URISyntaxException {
        List<FileAndAccountModel> fileAndAccountModelList = getListOfAccountModelsFromJsonFiles();

        for (FileAndAccountModel fileAndAccountModel : fileAndAccountModelList) {
            System.out.println(fileAndAccountModel.getFileName());
            System.out.println(fileAndAccountModel.getAccountModel().toString());
        }

        Assert.assertTrue(true);
    }
}
