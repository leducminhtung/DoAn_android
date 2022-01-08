package Model;

public class TaiKhoanInsertModel
{
    private String UserName;

    private String MaTK;

    private String Password;

    public String getUserName ()
    {
        return UserName;
    }

    public void setUserName (String UserName)
    {
        this.UserName = UserName;
    }

    public String getMaTK ()
    {
        return MaTK;
    }

    public void setMaTK (String MaTK)
    {
        this.MaTK = MaTK;
    }

    public String getPassword ()
    {
        return Password;
    }

    public void setPassword (String Password)
    {
        this.Password = Password;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [UserName = "+UserName+", MaTK = "+MaTK+", Password = "+Password+"]";
    }
}
