package Model;

public class VeMayBayInsertModel
{
    private String LoaiVe;

    private String NgayLap;

    private String MaHD;

    private String Id;

    private String TongTien;

    private String MaTK;

    public String getLoaiVe ()
    {
        return LoaiVe;
    }

    public void setLoaiVe (String LoaiVe)
    {
        this.LoaiVe = LoaiVe;
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

    public String getId ()
    {
        return Id;
    }

    public void setId (String Id)
    {
        this.Id = Id;
    }

    public String getTongTien ()
    {
        return TongTien;
    }

    public void setTongTien (String TongTien)
    {
        this.TongTien = TongTien;
    }

    public String getMaTK ()
    {
        return MaTK;
    }

    public void setMaTK (String MaTK)
    {
        this.MaTK = MaTK;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [LoaiVe = "+LoaiVe+", NgayLap = "+NgayLap+", MaHD = "+MaHD+", Id = "+Id+", TongTien = "+TongTien+", MaTK = "+MaTK+"]";
    }
}
