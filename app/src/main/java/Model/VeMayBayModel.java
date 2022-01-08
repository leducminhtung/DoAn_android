package Model;

import java.io.Serializable;
import java.util.List;

public class VeMayBayModel implements Serializable
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
    public class Data implements Serializable
    {
        private String stt;

        private String maHD;

        private String ngayLap;

        private String tongTien;

        private String id;

        private String loaiVe;

        public String getStt ()
        {
            return stt;
        }

        public void setStt (String stt)
        {
            this.stt = stt;
        }

        public String getMaHD ()
        {
            return maHD;
        }

        public void setMaHD (String maHD)
        {
            this.maHD = maHD;
        }

        public String getNgayLap ()
        {
            return ngayLap;
        }

        public void setNgayLap (String ngayLap)
        {
            this.ngayLap = ngayLap;
        }

        public String getTongTien ()
        {
            return tongTien;
        }

        public void setTongTien (String tongTien)
        {
            this.tongTien = tongTien;
        }


      
        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        

        public String getLoaiVe ()
        {
            return loaiVe;
        }

        public void setLoaiVe (String loaiVe)
        {
            this.loaiVe = loaiVe;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [stt = "+stt+", maHD = "+maHD+", ngayLap = "+ngayLap+", tongTien = "+tongTien+", id = "+id+",loaiVe = "+loaiVe+"]";
        }
    }
    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+"]";
    }
}
