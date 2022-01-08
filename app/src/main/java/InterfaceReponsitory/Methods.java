package InterfaceReponsitory;

import Model.CangBayModel;
import Model.ChuyenBayModel;
import Model.HoaDonModel;
import Model.KhachHangModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Methods {
    @GET("api/ChuyenBay/get-chuyenbay")
    Call<ChuyenBayModel> getChuyenBay();

    @GET("api/CangBay/get-cangbay")
    Call<CangBayModel> getCangBay();

    @GET("api/Khach/get-Khach")
    Call<KhachHangModel> getKhachHang();

    @GET("api/HoaDon/get-HoaDon")
    Call<HoaDonModel> getHoaDon();

    @GET("api/TaiKhoan/get-TaiKhoan")
    Call<TaiKhoanModel> getTaiKhoan();

    @GET("api/VeMayBay/get-VeMayBay")
    Call<CangBayModel> getVeMayBay();


}
