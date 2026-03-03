package mini;

import java.util.*;

public class Main {
    public static Repository<Pet> khoThuCung = new Repository<>();
    public static Map<String, Customer> danhSachKhachHang = new HashMap<>();
    public static Queue<SpaServiceTicket> hangDoiSpa = new LinkedList<>();
    public static ActionStack<ActivityLog> nhatKy = new ActionStack<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== PET KINGDOM =====");
            System.out.println("1. Thêm thú cưng");
            System.out.println("2. Hiển thị danh sách thú cưng");
            System.out.println("3. Xóa thú cưng");
            System.out.println("4. Đăng ký khách hàng");
            System.out.println("5. Hiển thị khách hàng");
            System.out.println("6. Thêm phiếu dịch vụ Spa");
            System.out.println("7. Xử lý dịch vụ Spa");
            System.out.println("8. Hoàn tác thao tác gần nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    themThuCung();
                    break;
                case 2:
                    hienThiThuCung();
                    break;
                case 3:
                    xoaThuCung();
                    break;
                case 4:
                    dangKyKhachHang();
                    break;
                case 5:
                    hienThiKhachHang();
                    break;
                case 6:
                    themDichVuSpa();
                    break;
                case 7:
                    xuLySpa();
                    break;
                case 8:
                    undo();
                    break;
                default:
                    System.out.println("Thoát chương trình");
                    break;
            }

        } while (choice != 0);
    }
    public static void themThuCung() {
        System.out.print("Mã thú cưng: ");
        String id = sc.nextLine();
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("Loài: ");
        String species = sc.nextLine();
        System.out.print("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Mã chủ sở hữu: ");
        String ownerId = sc.nextLine();

        Pet pet = new Pet(id, name, species, age, price, ownerId);
        khoThuCung.add(pet);
        nhatKy.push(new ActivityLog("Đã thêm thú cưng " + id));
        System.out.println("Thêm thành công");
    }
    public static void hienThiThuCung() {
        if (khoThuCung.getAll().isEmpty()) {
            System.out.println("Kho thú cưng đang trống");
        } else {
            khoThuCung.getAll().forEach(System.out::println);
        }
    }
    public static void xoaThuCung() {
        System.out.print("Nhập mã thú cưng cần xóa: ");
        String id = sc.nextLine();
        Pet timThay = null;
        for (Pet p : khoThuCung.getAll()) {
            if (p.getId().equals(id)) {
                timThay = p;
                break;
            }
        }
        if (timThay != null) {
            khoThuCung.remove(timThay);
            nhatKy.push(new ActivityLog("Đã xóa thú cưng " + id));
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tìm thấy thú cưng");
        }
    }

    public static void dangKyKhachHang() {
        System.out.print("Mã khách hàng: ");
        String id = sc.nextLine();
        if (danhSachKhachHang.containsKey(id)) {
            System.out.println("Khách hàng đã tồn tại");
            return;
        }
        System.out.print("Tên khách hàng: ");
        String name = sc.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = sc.nextLine();

        Customer kh = new Customer(id, name, phone);
        danhSachKhachHang.put(id, kh);
        nhatKy.push(new ActivityLog("Đã đăng ký khách hàng " + id));
        System.out.println("Đăng ký thành công!");
    }
    public static void hienThiKhachHang() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Chưa có khách hàng nào");
        } else {
            danhSachKhachHang.values().forEach(System.out::println);
        }
    }
    public static void themDichVuSpa() {
        System.out.print("Mã phiếu: ");
        String ticketId = sc.nextLine();
        System.out.print("Mã thú cưng: ");
        String petId = sc.nextLine();
        System.out.print("Loại dịch vụ: ");
        String service = sc.nextLine();

        SpaServiceTicket ticket = new SpaServiceTicket(ticketId, petId, service);
        hangDoiSpa.offer(ticket);
        nhatKy.push(new ActivityLog("Đã thêm phiếu Spa " + ticketId));
        System.out.println("Đã thêm vào hàng đợi Spa");
    }
    public static void xuLySpa() {
        SpaServiceTicket ticket = hangDoiSpa.poll();
        if (ticket != null) {
            nhatKy.push(new ActivityLog("Đã xử lý một phiếu Spa"));
            System.out.println("Đang phục vụ: " + ticket);
        } else {
            System.out.println("Không có thú cưng trong hàng đợi");
        }
    }
    public static void undo() {
        ActivityLog ganNhat = nhatKy.pop();
        if (ganNhat != null) {
            System.out.println("Hoàn tác thao tác: " + ganNhat);
        } else {
            System.out.println("Không có thao tác nào để hoàn tác.");
        }
    }
}
