package ro.siit.aut.gr4.exam.test.model;

public class FileAndAccountModel {

    AccountModel accountModel;
    String fileName;

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileAndAccountModel(AccountModel accountModel, String fileName) {
        this.accountModel = accountModel;
        this.fileName = fileName;
    }
}
