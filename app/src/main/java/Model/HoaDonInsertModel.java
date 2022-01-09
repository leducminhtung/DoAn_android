package Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.doan_android.Activity.Login;

import java.time.LocalDateTime;

public class HoaDonInsertModel
{
    private String SL_EmBe;

    private String SL_NguoiLon;

    private String MaKhach;

    private String NgayLap;

    private String MaHD;

    private String SL_TreEm;

    private String TongTien;

    public String getSL_EmBe ()
    {
        return SL_EmBe;
    }

    public void setSL_EmBe (String SL_EmBe)
    {
        this.SL_EmBe = SL_EmBe;
    }

    public String getSL_NguoiLon ()
    {
        return SL_NguoiLon;
    }

    public void setSL_NguoiLon (String SL_NguoiLon)
    {
        this.SL_NguoiLon = SL_NguoiLon;
    }

    public String getMaKhach ()
    {
        return MaKhach;
    }

    public void setMaKhach (String MaKhach)
    {
        this.MaKhach = MaKhach;
    }

    public String getNgayLap ()
    {
        return NgayLap;
    }

    public void setNgayLap (String NgayLap)
    {
        this.NgayLap = NgayLap;
    }

    public String getMaHD ()
    {
        return MaHD;
    }

    public void setMaHD (String MaHD)
    {
        this.MaHD = MaHD;
    }

    public String getSL_TreEm ()
    {
        return SL_TreEm;
    }

    public void setSL_TreEm (String SL_TreEm)
    {
        this.SL_TreEm = SL_TreEm;
    }

    public String getTongTien ()
    {
        return TongTien;
    }

    public void setTongTien (String TongTien)
    {
        this.TongTien = TongTien;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public HoaDonInsertModel(){
        MaHD = "00000000-0000-0000-0000-000000000000";
        MaKhach = Login.TaiKhoan.getMaTK();
        SL_EmBe = "0";
        SL_NguoiLon = "0";
        SL_TreEm = "0";
        TongTien = "0";
        NgayLap = LocalDateTime.now().toString();
    }
    @Override
    public String toString()
    {
        return "ClassPojo [SL_EmBe = "+SL_EmBe+", SL_NguoiLon = "+SL_NguoiLon+", MaKhach = "+MaKhach+", NgayLap = "+NgayLap+", MaHD = "+MaHD+", SL_TreEm = "+SL_TreEm+", TongTien = "+TongTien+"]";
    }
}