package PracticaAvionesVictorRuiz.rutas_aviones.service;

import PracticaAvionesVictorRuiz.rutas_aviones.model.Ciudad;
import PracticaAvionesVictorRuiz.rutas_aviones.model.Enlace;
import PracticaAvionesVictorRuiz.rutas_aviones.repository.CiudadRepository;
import PracticaAvionesVictorRuiz.rutas_aviones.repository.EnlaceRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RutaService {

    private final CiudadRepository ciudadRepo;
    private final EnlaceRepository enlaceRepo;

    public RutaService(CiudadRepository ciudadRepo, EnlaceRepository enlaceRepo) {
        this.ciudadRepo = ciudadRepo;
        this.enlaceRepo = enlaceRepo;
    }

    public Map<String, Object> calcularRuta(Integer origen, Integer destino, Integer omit) {
        // 1. ID->Nombre
        List<Ciudad> ciudades = ciudadRepo.findAll();
        Map<Integer, String> cityMap = new HashMap<>();
        for (Ciudad c : ciudades) {
            cityMap.put(c.getId(), c.getNombre());
        }

        // 2. Obtener todos los enlaces
        List<Enlace> enlaces = enlaceRepo.findAll();

        // 3. Construir la adyacencia (Map<Integer, Map<Integer,Integer>>)
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for (Enlace e : enlaces) {
            int o = e.getIdOrigen();
            int d = e.getIdDestino();
            int peso = e.getTiempo();

            // Si omit no es null y coincide con o o d, no agregamos
            if (omit != null && (o == omit || d == omit)) {
                continue;
            }
            adj.putIfAbsent(o, new HashMap<>());
            adj.get(o).put(d, peso);
        }

        // 4. Si omit existe, eliminar completamente omit
        if (omit != null) {
            // Eliminar el nodo
            adj.remove(omit);
            // Eliminar referencias a omit en los otros
            for (Integer nodo : adj.keySet()) {
                adj.get(nodo).remove(omit);
            }
        }

        // 5. Aplicar Dijkstra (o BFS si todos son 1). Aquí un mini Dijkstra
        List<Integer> path = dijkstra(origen, destino, adj);
        if (path.isEmpty()) {
            // No hay ruta
            Map<String, Object> err = new HashMap<>();
            err.put("error", "No se encontró una ruta entre las ciudades dadas");
            return err;
        }

        // 6. Convertir IDs a Nombres
        List<String> rutaNombres = new ArrayList<>();
        for (Integer id : path) {
            rutaNombres.add(cityMap.getOrDefault(id, "ID:"+id));
        }

        // Para calcular el costo total, sumamos la “tiempo” con la tabla “adj”
        // O lo haces directamente en dijkstra, que retorna el costo.
        int costoTotal = calcularCostoTotal(path, adj);

        // 7. Retornar
        Map<String, Object> result = new HashMap<>();
        result.put("origen", cityMap.getOrDefault(origen, "ID:"+origen));
        result.put("destino", cityMap.getOrDefault(destino, "ID:"+destino));
        result.put("ruta", rutaNombres);
        result.put("costo", costoTotal);
        if (omit != null) {
            result.put("omitido", cityMap.getOrDefault(omit, "ID:"+omit));
        } else {
            result.put("omitido", null);
        }
        return result;
    }

    private List<Integer> dijkstra(Integer start, Integer end, Map<Integer, Map<Integer, Integer>> adj) {
        // Distancia
        Map<Integer, Integer> dist = new HashMap<>();
        // Predecesores
        Map<Integer, Integer> prev = new HashMap<>();
        // Nodos sin visitar
        Set<Integer> unvisited = new HashSet<>(adj.keySet());

        // Inicializar
        for (Integer n : adj.keySet()) {
            dist.put(n, Integer.MAX_VALUE);
            prev.put(n, null);
        }
        // Si no existe start en adj, no hay ruta
        if (!adj.containsKey(start)) {
            return Collections.emptyList();
        }
        dist.put(start, 0);

        // Dijkstra
        while (!unvisited.isEmpty()) {
            // 1. Escoger el nodo con dist mínima
            Integer current = null;
            int minDist = Integer.MAX_VALUE;
            for (Integer n : unvisited) {
                int d = dist.getOrDefault(n, Integer.MAX_VALUE);
                if (d < minDist) {
                    minDist = d;
                    current = n;
                }
            }
            if (current == null) break; // no hay nodos alcanzables
            if (current.equals(end)) break;

            unvisited.remove(current);

            // 2. Relajar vecinos
            Map<Integer, Integer> neighbors = adj.getOrDefault(current, new HashMap<>());
            for (Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                Integer vecino = entry.getKey();
                int cost = entry.getValue();
                int alt = dist.get(current) + cost;
                if (alt < dist.getOrDefault(vecino, Integer.MAX_VALUE)) {
                    dist.put(vecino, alt);
                    prev.put(vecino, current);
                }
            }
        }

        // Reconstruir camino si dist[end] no es infinito
        if (!dist.containsKey(end) || dist.get(end) == Integer.MAX_VALUE) {
            return Collections.emptyList();
        }

        // Reconstruir
        List<Integer> path = new LinkedList<>();
        Integer temp = end;
        while (temp != null) {
            path.add(0, temp);
            temp = prev.get(temp);
        }
        return path;
    }

    private int calcularCostoTotal(List<Integer> path, Map<Integer, Map<Integer, Integer>> adj) {
        if (path.size() < 2) return 0;
        int total = 0;
        for (int i=0; i < path.size() - 1; i++) {
            int current = path.get(i);
            int next = path.get(i+1);
            total += adj.get(current).get(next);
        }
        return total;
    }
}
