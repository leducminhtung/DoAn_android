package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class KhachHangModel implements Serializable
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

    public static class Data implements Serializable
    {

        private String sdt;

        private String ngaySinh;

        private String maKhach;

        private String hoTen;

        private String gioiTinh;

        private String ten;

        private String email;

        private String cccd;

        public Data(){
            sdt = "";
            ngaySinh = "00/00/00";
            maKhach = "00000000-0000-0000-0000-000000000000";
            hoTen ="";
            gioiTinh = "";
            ten = "USER";
            email ="";
            cccd ="";
        }

        public String getSdt ()
        {
            return sdt;
        }

        public void setSdt (String sdt)
        {
            this.sdt = sdt;
        }

        public String getNgaySinh ()
        {
            return ngaySinh;
        }

        public void setNgaySinh (String ngaySinh)
        {
            this.ngaySinh = ngaySinh;
        }

        public String getMaKhach ()
        {
            return maKhach;
        }

        public void setMaKhach (String maKhach)
        {
            this.maKhach = maKhach;
        }

        public String getHoTen ()
        {
            return hoTen;
        }

        public void setHoTen (String hoTen)
        {
            this.hoTen = hoTen;
        }

        public String getGioiTinh ()
        {
            return gioiTinh;
        }

        public void setGioiTinh (String gioiTinh)
        {
            this.gioiTinh = gioiTinh;
        }

        public String getTen ()
        {
            return ten;
        }

        public void setTen (String ten)
        {
            this.ten = ten;
        }

        public String getEmail ()
        {
            return email;
        }

        public void setEmail (String email)
        {
            this.email = email;
        }

        public String getCccd ()
        {
            return cccd;
        }

        public void setCccd (String cccd)
        {
            this.cccd = cccd;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [sdt = "+sdt+", ngaySinh = "+ngaySinh+", maKhach = "+maKhach+", hoTen = "+hoTen+", gioiTinh = "+gioiTinh+", ten = "+ten+", email = "+email+", cccd = "+cccd+"]";
        }
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+"]";
    }
}
