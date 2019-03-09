package arkham.knight.practica4.service;

import java.util.List;
import java.util.Set;

import arkham.knight.practica4.encapsulacion.Etiqueta;

public class EtiquetaService extends DataBaseService<Etiqueta> {
    private static EtiquetaService instancia;

    private EtiquetaService() {
        super(Etiqueta.class);
    }

    public static EtiquetaService getInstancia() {
        if (instancia == null) {
            instancia = new EtiquetaService();
        }
        return instancia;
    }

    public static void agregarEtiquetas(String[] etiquetas, Set<Etiqueta> etiquetasSet) {
        List<Etiqueta> tags = EtiquetaService.getInstancia().findAll();
        for (int i = 0; i < etiquetas.length; i++) {
            Etiqueta et = new Etiqueta(etiquetas[i]);
            boolean esta = false;
            for (Etiqueta e : tags) {
                if (e.getEtiqueta().contains(etiquetas[i])) {
                    esta = true;
                }
            }

            if (!esta) {
                EtiquetaService.getInstancia().crear(et);
                tags = EtiquetaService.getInstancia().findAll();
            }
        }

        for (int i = 0; i < etiquetas.length; i++) {
            for (Etiqueta e : EtiquetaService.getInstancia().findAll()) {
                if (e.getEtiqueta().equals(etiquetas[i])) {
                    etiquetasSet.add(e);
                }
            }
        }
    }

    public static boolean seModificaronLasEtiquetas(Set<Etiqueta> etiquetas, Set<Etiqueta> setEtiquetas) {

        if ((etiquetas.size() == 0 && setEtiquetas.size() > 0) || (etiquetas.size() > 0 && setEtiquetas.size() == 0)) {
            return true;
        }
        for (Etiqueta etiquetaSet : setEtiquetas) {
            for (Etiqueta etiqueta : etiquetas) {
                if (!etiquetaSet.getEtiqueta().contains(etiqueta.getEtiqueta())) {
                    return true;
                }
            }
        }
        return false;
    }
}
