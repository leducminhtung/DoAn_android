package Model;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.doan_android.Activity.Login;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class HoaDonModel implements Serializable
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
        private String maHD;

        private String ngayLap;

        private String tongTien;

        private String sL_EmBe;

        private String sL_NguoiLon;

        private String sL_TreEm;

        private String maKhach;


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

        public String getSL_EmBe ()
        {
            return sL_EmBe;
        }

        public void setSL_EmBe (String sL_EmBe)
        {
            this.sL_EmBe = sL_EmBe;
        }

        public String getSL_NguoiLon ()
        {
            return sL_NguoiLon;
        }

        public void setSL_NguoiLon (String sL_NguoiLon)
        {
            this.sL_NguoiLon = sL_NguoiLon;
        }

        public String getSL_TreEm ()
        {
            return sL_TreEm;
        }

        public void setSL_TreEm (String sL_TreEm)
        {
            this.sL_TreEm = sL_TreEm;
        }

        public String getMaKhach ()
        {
            return maKhach;
        }

        public void setMaKhach (String maKhach)
        {
            this.maKhach = maKhach;
        }





        @Override
        public String toString()
        {
            return "ClassPojo [maHD = "+maHD+", ngayLap = "+ngayLap+", tongTien = "+tongTien+", sL_EmBe = "+sL_EmBe+", sL_NguoiLon = "+sL_NguoiLon+", sL_TreEm = "+sL_TreEm+", maKhach = "+maKhach+"]";
        }
    }
    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+"]";
    }
}