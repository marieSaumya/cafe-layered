package lk.ijse.freshBite.dao;

import lk.ijse.freshBite.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){

    }
    public static DaoFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory = new DaoFactory():daoFactory;
    }
    public enum DataTypes{
        ADD_MENU,ANALYTICS,CUSTOMER,PASSWORD,ITEM_CARD,LOGIN,
        MENU_ITEM,NOTIFICATION,ORDERS,ORDER_ITEM,PROFILE,QUERY,RESERVATION,
        STAFF,STOCK,SUPPLIER,SUP_STOCK
    }

    public SuperDao getDao(DataTypes dataTypes){
        switch (dataTypes){
            case LOGIN:return new LoginDaoImpl();
            case QUERY:return new QueryDaoImpl();
            case STAFF:return new StaffDetailDaoImpl();
            case STOCK:return new StockItemDaoImpl();
            case ORDERS:return new OrderDaoImpl();
            case PROFILE:return new ProfileDaoImpl();
            case ADD_MENU:return new AddMenuDaoImpl();
            case CUSTOMER:return new CustomerDetailDaoImpl();
            case PASSWORD:return new ForgotPasswordDaoImpl();
            case SUPPLIER:return new SupplierDaoImpl();
            case ANALYTICS:return new AnalyticsDaoImpl();
            case ITEM_CARD:return new ItemCardDaoImpl();
            case MENU_ITEM:return new MenueItemDaoImpl();
            case SUP_STOCK:return new SupStockDaoImpl();
            case ORDER_ITEM:return new OrderItemDaoImpl();
            case RESERVATION:return new ReservationDaoImpl();
            case NOTIFICATION:return new NotificationDaoImpl();
            default:return null;

        }
    }
}
