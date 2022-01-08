package Model;

public class KhachInsertModel
{
    private String GioiTinh;

    private String MaKhach;

    private String SDT;

    private String Email;

    private String NgaySinh;

    private String HoTen;

    private String Ten;

    private String CCCD;

    public String getGioiTinh ()
    {
        return GioiTinh;
    }

    public void setGioiTinh (String GioiTinh)
    {
        this.GioiTinh = GioiTinh;
    }

    public String getMaKhach ()
    {
        return MaKhach;
    }

    public void setMaKhach (String MaKhach)
    {
        this.MaKhach = MaKhach;
    }

    public String getSDT ()
    {
        return SDT;
    }

    public void setSDT (String SDT)
    {
        this.SDT = SDT;
    }

    public String getEmail ()
    {
        return Email;
    }

    public void setEmail (String Email)
    {
        this.Email = Email;
    }

    public String getNgaySinh ()
    {
        return NgaySinh;
    }

    public void setNgaySinh (String NgaySinh)
    {
        this.NgaySinh = NgaySinh;
    }

    public String getHoTen ()
    {
        return HoTen;
    }

    public void setHoTen (String HoTen)
    {
        this.HoTen = HoTen;
    }

    public String getTen ()
    {
        return Ten;
    }

    public void setTen (String Ten)
    {
        this.Ten = Ten;
    }

    public String getCCCD ()
    {
        return CCCD;
    }

    public void setCCCD (String CCCD)
    {
        this.CCCD = CCCD;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [GioiTinh = "+GioiTinh+", MaKhach = "+MaKhach+", SDT = "+SDT+", Email = "+Email+", NgaySinh = "+NgaySinh+", HoTen = "+HoTen+", Ten = "+Ten+", CCCD = "+CCCD+"]";
    }
}
