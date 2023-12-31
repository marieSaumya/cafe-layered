package lk.ijse.freshBite.bo;

import lk.ijse.freshBite.bo.custom.impl.*;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory() {

    }
    public static BoFactory getBoFactory(){
        return (boFactory==null)?boFactory=new BoFactory():boFactory;
    }
    public enum BoTypes{
       ADD_MENU,ANALYTICS,CUSTOMER,DASHBOARD,PASSWORD,ITEM_CARD,LOGIN,MAIL,MENU_ITEM,
       NOTIFICATION,PROFILE,RESERVATION,STAFF,STOCK_ITEM,SUPPLIER

    }
    public SuperBo getBo(BoTypes types){
        switch (types){
            case NOTIFICATION:return new NotificationBoImpl();
            case RESERVATION:return new ReservationBoImpl();
            case MENU_ITEM:return new MenuItemBoImpl();
            case ANALYTICS:return new AnalyticsBoImpl();
            case SUPPLIER:return new SupplierBoImpl();
            case ITEM_CARD:return new ItemCardBoImpl();
            case PASSWORD:return new ForgotPwBoImpl();
            case CUSTOMER:return new CustomerBoImpl();
            case PROFILE:return new ProfileBoImpl();
            case STAFF:return new StaffDetailBoImpl();
            case LOGIN:return new LoginBoImpl();
            case ADD_MENU:return new AddMenuBoImpl();
            case MAIL:return new MailBoImpl();
            case DASHBOARD:return new DashboardBoImpl();
            case STOCK_ITEM:return new StockItemBoImpl();
            default:return null;

        }
    }

}
