import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user-pc on 17.07.2016.
 */
public class MenuHelper {
    public EntityManager em = Persistence.createEntityManagerFactory("MenuTest").createEntityManager();
    Random random = new Random();

    public Menu add(Menu menu) {
        em.getTransaction().begin();
        Menu dbMenu = em.merge(menu);
        em.getTransaction().commit();
        return dbMenu;
    }
    public void addRandomDishes(int count) {
        em.getTransaction().begin();
        for (int i = 1; i <= count; i++) {
            Menu menu = new Menu("Dish"+i, random.nextFloat()*10+i, random.nextFloat()*100+i, hasDiscount());
            em.persist(menu);
        }
        em.getTransaction().commit();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Menu get(long id) {
        return em.find(Menu.class, id);
    }

    public List<Menu> getAll(){
        TypedQuery<Menu> menuList = em.createNamedQuery("Menu.getAll", Menu.class);
        return menuList.getResultList();
    }

    public List<Menu> getDishesByPriceFromTo(float min, float max){
        TypedQuery<Menu> menuList = em.createQuery("SELECT m FROM Menu m WHERE (m.price >= :min AND m.price <= :max)", Menu.class);
        menuList.setParameter("min", min);
        menuList.setParameter("max", max);
        return menuList.getResultList();
    }

    public List<Menu> getDishesWithDiscount(){
        TypedQuery<Menu> menuList = em.createQuery("SELECT m FROM Menu m WHERE (m.discount > 0)", Menu.class);
        return menuList.getResultList();
    }

    public List<Menu> getDishesLessThanKilo(){
        float weightSum = 0F;
        List<Menu> menuList = new ArrayList<>();
        for (Menu menu : getAll()) {
            weightSum += menu.getWeight();
            if (weightSum>1_000) break;     //добавляем в menuList блюда пока общий вес не превышает килограмма
            menuList.add(menu);
        }
        return menuList;
    }

    public int hasDiscount() {
        if (random.nextBoolean()) return 10;
        else return 0;
    }





}
