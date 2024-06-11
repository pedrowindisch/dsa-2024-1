package MapaDispersao;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import com.pedrowindisch.MapaDispersao.Aluno;
import com.pedrowindisch.MapaDispersao.MapaDispersao;

public class MapaDispersaoTest {
    @Test
    public void testInserir() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
        Aluno aluno = new Aluno(12000, "Jean", LocalDate.of(2000, 01, 01));

        mapa.inserir(12000, aluno);

        Assert.assertEquals(mapa.buscar(aluno.getMatricula()), aluno);
    }

    @Test
    public void testInserirVarios() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
        Aluno jean = new Aluno(12000, "Jean", LocalDate.of(2000, 01, 01));
        Aluno pedro = new Aluno(14000, "Pedro", LocalDate.of(1999, 01, 20));
        Aluno marta = new Aluno(12500, "Marta", LocalDate.of(2001, 02, 18));
        Aluno lucas = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(jean.getMatricula(), jean);
        mapa.inserir(pedro.getMatricula(), pedro);
        mapa.inserir(marta.getMatricula(), marta);
        mapa.inserir(lucas.getMatricula(), lucas);

        Assert.assertEquals(mapa.buscar(jean.getMatricula()), jean);
        Assert.assertEquals(mapa.buscar(pedro.getMatricula()), pedro);
        Assert.assertEquals(mapa.buscar(marta.getMatricula()), marta);
        Assert.assertEquals(mapa.buscar(lucas.getMatricula()), lucas);
    }


    @Test
    public void testInserirVariosComColisao() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
        Aluno jean = new Aluno(12000, "Jean", LocalDate.of(2000, 01, 01));
        Aluno pedro = new Aluno(14000, "Pedro", LocalDate.of(1999, 01, 20));
        Aluno marta = new Aluno(14226, "Marta", LocalDate.of(2001, 02, 18));
        Aluno lucas = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(jean.getMatricula(), jean);
        mapa.inserir(pedro.getMatricula(), pedro);
        mapa.inserir(marta.getMatricula(), marta);
        mapa.inserir(lucas.getMatricula(), lucas);

        Assert.assertEquals(mapa.buscar(jean.getMatricula()), jean);
        Assert.assertEquals(mapa.buscar(pedro.getMatricula()), pedro);
        Assert.assertEquals(mapa.buscar(marta.getMatricula()), marta);
        Assert.assertEquals(mapa.buscar(lucas.getMatricula()), lucas);
    }
}
