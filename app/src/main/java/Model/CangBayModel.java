package Model;

import java.io.Serializable;
import java.util.List;
public class CangBayModel implements Serializable
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
        private String maCB;

        private String tenMB;

        private String id;

        public String getMaCB ()
        {
            return maCB;
        }

        public void setMaCB (String maCB)
        {
            this.maCB = maCB;
        }

        public String getTenMB ()
        {
            return tenMB;
        }

        public void setTenMB (String tenMB)
        {
            this.tenMB = tenMB;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [maCB = "+maCB+", tenMB = "+tenMB+", id = "+id+"]";
        }
    }
}
