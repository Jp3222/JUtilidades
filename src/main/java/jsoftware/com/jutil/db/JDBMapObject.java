package jsoftware.com.jutil.db;

import java.util.Map;
import jsoftware.com.jutil.db.model.JDBObject;
import jsoftware.com.jutil.model.AbstractMapDTO;
import jsoftware.com.jutil.util.JFunc;

/**
 * Representación genérica de un objeto de base de datos con estructura interna
 * de Map.
 * <br>
 * Une el transporte flexible de datos con las capacidades de identificación y
 * ordenamiento requeridas por la persistencia de JBlue.
 *
 * @author JUAN PABLO CAMPOS CASASANERO
 * @since 2026-05-30
 * @version 1.1
 */
public class JDBMapObject extends AbstractMapDTO implements JDBObject {

    private static final long serialVersionUID = 1L;

    public JDBMapObject(Map<String, Object> map) {
        super(map);
    }

    public JDBMapObject(int size) {
        // Estándar: Delegamos directamente al constructor de tamaño de la clase padre
        super(size);
    }

    public JDBMapObject() {
        // Mantiene tu tamaño inicial óptimo para consultas e inserciones genéricas
        super(20);
    }

    @Override
    public String getId() {
        // Estándar: Protección defensiva con tu función de sanitización
        return JFunc.nullSafeToString(get("id"));
    }

    @Override
    public int compareTo(JDBObject o) {
        if (o == null) {
            return 1; // Los objetos existentes se posicionan por encima de referencias nulas
        }
        // Compara lexicográficamente las cadenas de los IDs para ordenamientos automáticos
        return this.getId().compareTo(o.getId());
    }
}
