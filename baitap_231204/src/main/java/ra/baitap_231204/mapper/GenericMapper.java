package ra.baitap_231204.mapper;

public interface GenericMapper<E,T,U> {
    //E: entity, T: Request, U: Response
    //1. Phương thức chuyển đổi từ RequestDTO --> entity
    E toEntity(T t);
    //2. Phương thức chuyển đổi từ entity --> ResponseDTO
    U toResponse(E e);
}
