package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    private static Map<String, Class> mapaGrup = new HashMap<>();
    private static List<Class> listaGrup = new ArrayList<Class>();


    @Override
    public String toString() {
        return "ClassContainer{" +
                "listaGrup=" + mapaGrup +
                '}';
    }

    public Class getClassById(int id) {
        return listaGrup.get(id);
    }

    public Class getClassByName(String name) {
        return mapaGrup.get(name);
    }

    public Integer getGroupSize() {
        return listaGrup.size();
    }

    public void addClass(String nazwa, int pojemnosc) {
        Class temp = new Class(nazwa, pojemnosc);
        mapaGrup.put(nazwa, temp);
        listaGrup.add(temp);
//        System.out.println("TUUUU " + getGroupSize());
    }

    public void removeClass(String nazwa) {
        if (mapaGrup.containsKey(nazwa)) {
            mapaGrup.remove(nazwa);
            for (int i = 0; i < listaGrup.size(); i++) {
                if (listaGrup.get(i).getNazwaGrupy().equals(nazwa)) {
                    listaGrup.remove(i);
                    break;
                }
            }
            System.out.println("Usunieto klase");
        } else {
            System.out.println("Taka klasa nie istnieje!");
        }
    }

    public List<Class> findEmpty() {
        List<Class> listaPustychKlas = new ArrayList<Class>();
        for (Map.Entry<String, Class> klasa : mapaGrup.entrySet()) {
            if (klasa.getValue().getListaStudentow().size() == 0) {
                listaPustychKlas.add(klasa.getValue());
            }
        }
        return listaPustychKlas;
    }

    public void summary() {
        int zapelnienie = 0;
        for (Map.Entry<String, Class> klasa : mapaGrup.entrySet()) {
            zapelnienie = (int) ((double) klasa.getValue().getListaStudentow().size() / (double) klasa.getValue().getMaksymalnaIloscStudentow() * 100);
            System.out.println(klasa.getKey() + " zapelnienie = " + zapelnienie + "%");
        }
    }

    public void changeGroupName(int id, String newName) {
        String oldName = listaGrup.get(id).getNazwaGrupy();
        Class temp = mapaGrup.remove(oldName);
        mapaGrup.put(newName, temp);
        listaGrup.get(id).setNazwaGrupy(newName);
    }
}
