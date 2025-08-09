# Các sửa đổi để khắc phục lỗi HttpMessageNotWritableException

## Nguyên nhân lỗi:
Lỗi `Cannot call sendError() after the response has been committed` xảy ra do:
1. Circular reference trong JSON serialization giữa các entity
2. Thiếu exception handling trong controllers
3. Vấn đề với lazy loading trong Hibernate
4. Thiếu dữ liệu mẫu trong database

## Các sửa đổi đã thực hiện:

### 1. Cải thiện Exception Handling
- Thêm `GlobalExceptionHandler` để xử lý tất cả các exception
- Cập nhật `msgController` để sử dụng `ResponseEntity` với try-catch
- Thêm exception handling trong `ChatMessageService`

### 2. Khắc phục Circular Reference
- Thêm `@JsonIgnoreProperties` cho các relationship trong entities
- Thêm `@JsonIgnore` cho password field
- Tạo `MessageDTO` để tránh circular reference khi serialize JSON

### 3. Cải thiện Service Layer
- Thêm validation trong `ChatMessageService`
- Sử dụng DTO thay vì entity trực tiếp
- Thêm logging thay vì throw exception

### 4. Cấu hình Application
- Thêm cấu hình JSON serialization trong `application.properties`
- Thêm cấu hình Hibernate để tránh lazy loading issues
- Tạo `DataInitializationService` để khởi tạo dữ liệu mẫu

### 5. Sửa Repository
- Sửa `AcountRepository` để sử dụng `Integer` thay vì `Long`
- Tạo `ConversationRepository` interface

## Cách test:
1. Khởi động ứng dụng
2. Test endpoint: `GET /api/test/health`
3. Test messages endpoint: `GET /api/messages/recent`

## Lưu ý:
- Đảm bảo MySQL server đang chạy
- Database sẽ được tạo tự động nếu chưa tồn tại
- Conversation mặc định sẽ được tạo với ID = 1 