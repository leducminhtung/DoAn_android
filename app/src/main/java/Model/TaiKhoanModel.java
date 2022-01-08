package Model;

import java.io.Serializable;
import java.util.List;

public class TaiKhoanModel implements Serializable
{
    private List<Data> data;

    private String status;

    public List<Data> getData ()
    {
        return data;
    }

    public void setData (List<Data> data)
    {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+"]";
    }

    public class Data implements Serializable
    {
        private String password;

        private String maTK;

        private String userName;

        private String status;

        public String getPassword ()
        {
            return password;
        }

        public void setPassword (String password)
        {
            this.password = password;
        }

        public String getMaTK ()
        {
            return maTK;
        }

        public void setMaTK (String maTK)
        {
            this.maTK = maTK;
        }

        public String getUserName ()
        {
            return userName;
        }

        public void setUserName (String userName)
        {
            this.userName = userName;
        }

        public String getStatus ()
        {
            return status;
        }

        public void setStatus (String status)
        {
            this.status = status;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [password = "+password+", maTK = "+maTK+", userName = "+userName+", status = "+status+"]";
        }
    }
}