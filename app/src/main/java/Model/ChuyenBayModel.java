package Model;

import java.io.Serializable;
import java.util.List;

public class ChuyenBayModel implements Serializable
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

        private String macangden;

        private String thuephisanbaynguoilon;

        private String giadichvuembe;

        private String soLuongEmBe;

        private String tencangden;

        private String ngayGioDen;

        private String ngayGioDi;

        private String thoiGianBay;

        private String giatreem;

        private String ngayDi;

        private String id;

        private String soLuongNguoiLon;

        private String soLuongTreEm;

        private String tenMB;

        private String tongtien;

        private String ngayDen;

        private String tenhang;

        private String macangdi;

        private String giadichvutreem;

        private String picture;

        private String thuephisanbayembe;

        private String gioDi;

        private String tencangdi;

        private String thuephisanbaytreem;

        private String giadichvunguoilon;

        private String gianguoilon;

        private String gioDen;

        private String giaembe;

        public String getMaCB ()
        {
            return maCB;
        }

        public void setMaCB (String maCB)
        {
            this.maCB = maCB;
        }

        public String getMacangden ()
        {
            return macangden;
        }

        public void setMacangden (String macangden)
        {
            this.macangden = macangden;
        }

        public String getThuephisanbaynguoilon ()
        {
            return thuephisanbaynguoilon;
        }

        public void setThuephisanbaynguoilon (String thuephisanbaynguoilon)
        {
            this.thuephisanbaynguoilon = thuephisanbaynguoilon;
        }

        public String getGiadichvuembe ()
        {
            return giadichvuembe;
        }

        public void setGiadichvuembe (String giadichvuembe)
        {
            this.giadichvuembe = giadichvuembe;
        }

        public String getSoLuongEmBe ()
        {
            return soLuongEmBe;
        }

        public void setSoLuongEmBe (String soLuongEmBe)
        {
            this.soLuongEmBe = soLuongEmBe;
        }

        public String getTencangden ()
        {
            return tencangden;
        }

        public void setTencangden (String tencangden)
        {
            this.tencangden = tencangden;
        }

        public String getNgayGioDen ()
        {
            return ngayGioDen;
        }

        public void setNgayGioDen (String ngayGioDen)
        {
            this.ngayGioDen = ngayGioDen;
        }

        public String getNgayGioDi ()
        {
            return ngayGioDi;
        }

        public void setNgayGioDi (String ngayGioDi)
        {
            this.ngayGioDi = ngayGioDi;
        }

        public String getThoiGianBay ()
        {
            return thoiGianBay;
        }

        public void setThoiGianBay (String thoiGianBay)
        {
            this.thoiGianBay = thoiGianBay;
        }

        public String getGiatreem ()
        {
            return giatreem;
        }

        public void setGiatreem (String giatreem)
        {
            this.giatreem = giatreem;
        }

        public String getNgayDi ()
        {
            return ngayDi;
        }

        public void setNgayDi (String ngayDi)
        {
            this.ngayDi = ngayDi;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getSoLuongNguoiLon ()
        {
            return soLuongNguoiLon;
        }

        public void setSoLuongNguoiLon (String soLuongNguoiLon)
        {
            this.soLuongNguoiLon = soLuongNguoiLon;
        }

        public String getSoLuongTreEm ()
        {
            return soLuongTreEm;
        }

        public void setSoLuongTreEm (String soLuongTreEm)
        {
            this.soLuongTreEm = soLuongTreEm;
        }

        public String getTenMB ()
        {
            return tenMB;
        }

        public void setTenMB (String tenMB)
        {
            this.tenMB = tenMB;
        }

        public String getTongtien ()
        {
            return tongtien;
        }

        public void setTongtien (String tongtien)
        {
            this.tongtien = tongtien;
        }

        public String getNgayDen ()
        {
            return ngayDen;
        }

        public void setNgayDen (String ngayDen)
        {
            this.ngayDen = ngayDen;
        }

        public String getTenhang ()
        {
            return tenhang;
        }

        public void setTenhang (String tenhang)
        {
            this.tenhang = tenhang;
        }

        public String getMacangdi ()
        {
            return macangdi;
        }

        public void setMacangdi (String macangdi)
        {
            this.macangdi = macangdi;
        }

        public String getGiadichvutreem ()
        {
            return giadichvutreem;
        }

        public void setGiadichvutreem (String giadichvutreem)
        {
            this.giadichvutreem = giadichvutreem;
        }

        public String getPicture ()
        {
            return picture;
        }

        public void setPicture (String picture)
        {
            this.picture = picture;
        }

        public String getThuephisanbayembe ()
        {
            return thuephisanbayembe;
        }

        public void setThuephisanbayembe (String thuephisanbayembe)
        {
            this.thuephisanbayembe = thuephisanbayembe;
        }

        public String getGioDi ()
        {
            return gioDi;
        }

        public void setGioDi (String gioDi)
        {
            this.gioDi = gioDi;
        }

        public String getTencangdi ()
        {
            return tencangdi;
        }

        public void setTencangdi (String tencangdi)
        {
            this.tencangdi = tencangdi;
        }

        public String getThuephisanbaytreem ()
        {
            return thuephisanbaytreem;
        }

        public void setThuephisanbaytreem (String thuephisanbaytreem)
        {
            this.thuephisanbaytreem = thuephisanbaytreem;
        }

        public String getGiadichvunguoilon ()
        {
            return giadichvunguoilon;
        }

        public void setGiadichvunguoilon (String giadichvunguoilon)
        {
            this.giadichvunguoilon = giadichvunguoilon;
        }

        public String getGianguoilon ()
        {
            return gianguoilon;
        }

        public void setGianguoilon (String gianguoilon)
        {
            this.gianguoilon = gianguoilon;
        }

        public String getGioDen ()
        {
            return gioDen;
        }

        public void setGioDen (String gioDen)
        {
            this.gioDen = gioDen;
        }

        public String getGiaembe ()
        {
            return giaembe;
        }

        public void setGiaembe (String giaembe)
        {
            this.giaembe = giaembe;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [maCB = "+maCB+", macangden = "+macangden+", thuephisanbaynguoilon = "+thuephisanbaynguoilon+", giadichvuembe = "+giadichvuembe+", soLuongEmBe = "+soLuongEmBe+", tencangden = "+tencangden+", ngayGioDen = "+ngayGioDen+", ngayGioDi = "+ngayGioDi+", thoiGianBay = "+thoiGianBay+", giatreem = "+giatreem+", ngayDi = "+ngayDi+", id = "+id+", soLuongNguoiLon = "+soLuongNguoiLon+", soLuongTreEm = "+soLuongTreEm+", tenMB = "+tenMB+", tongtien = "+tongtien+", ngayDen = "+ngayDen+", tenhang = "+tenhang+", macangdi = "+macangdi+", giadichvutreem = "+giadichvutreem+", picture = "+picture+", thuephisanbayembe = "+thuephisanbayembe+", gioDi = "+gioDi+", tencangdi = "+tencangdi+", thuephisanbaytreem = "+thuephisanbaytreem+", giadichvunguoilon = "+giadichvunguoilon+", gianguoilon = "+gianguoilon+", gioDen = "+gioDen+", giaembe = "+giaembe+"]";
        }
    }

}

