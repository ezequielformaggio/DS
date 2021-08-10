package Atuendo;

import Prenda.Prenda;
import Prenda.Categoria;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneradorDeAtuendo {

  public Atuendo crearAtuendo(List<Prenda> prendas) {
    return new Atuendo(
        this.agregarPrenda(Categoria.PARTE_SUPERIOR, prendas),
        this.agregarPrenda(Categoria.PARTE_INFERIOR, prendas),
        this.agregarPrenda(Categoria.CALZADO, prendas),
        this.agregarPrenda(Categoria.ACCESORIO, prendas)
    );
  }

  public Prenda agregarPrenda(Categoria categoria, List<Prenda> prendas) {
    List<Prenda> prendasFiltradas = filtrarPrendas(categoria, prendas);
    return obtenerPrendaRandom(prendasFiltradas);
  }

  public Prenda obtenerPrendaRandom(List<Prenda> prendas){
    Random random = new Random();
    return prendas.get(random.nextInt(prendas.size()));
  }

  public List<Prenda> filtrarPrendas(Categoria categoria, List<Prenda> prendas){
    return prendas
        .stream()
        .filter(prenda -> prenda.getCategoria().equals(categoria))
        .collect(Collectors.toList());
  }

}

