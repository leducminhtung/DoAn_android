package InterfaceReponsitory;

import Model.CallbackResultModel;
import Model.CangBayModel;
import Model.ChuyenBayModel;
import Model.HoaDonInsertModel;
import Model.HoaDonModel;
import Model.KhachHangModel;
import Model.KhachInsertModel;
import Model.TaiKhoanInsertModel;
import Model.TaiKhoanModel;
import Model.VeMayBayInsertModel;
import Model.VeMayBayModel;
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
    Call<VeMayBayModel> getVeMayBay();

    @POST("api/TaiKhoan/insert-TaiKhoan")
    Call<CallbackResultModel> insertTaiKhoan(@Body TaiKhoanInsertModel taiKhoanInsertModel);

    @POST("api/VeMayBay/insert-VeMayBay")
    Call<CallbackResultModel> insertVeMayBay(@Body VeMayBayInsertModel veMayBayInsertModel);

    @POST("api/HoaDon/insert-HoaDon")
    Call<CallbackResultModel> insertHoaDon(@Body HoaDonInsertModel hoaDonInsertModel);

    @POST("api/Khach/insert-Khach")
    Call<CallbackResultModel> insertKhachHang(@Body KhachInsertModel khachInsertModel);

    @POST("api/TaiKhoan/edit-TaiKhoan")
    Call<CallbackResultModel> editTaiKhoan(@Body TaiKhoanInsertModel taiKhoanInsertModel);


}
