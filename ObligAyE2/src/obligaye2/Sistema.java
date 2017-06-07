package obligaye2;

import obligaye2.ISistema;
import obligaye2.TipoRetorno.TipoError;

public class Sistema implements ISistema {

	@Override
	public TipoRetorno inicializarSistema(int cantCiudadesMax, Double CoordXDestino, Double CoordYDestino,
			String nombreCiudadDestino, Double CoordXOrigen, Double CoordYOrigen, String nombreCiudadOrigen) {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno destruirSistema() {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno registrarCliente(String cedula, String nombre, String direccion, String email) {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno registrarCompra(String cedula, int trackingId, String empresa) {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno registrarCiudad(String Nombre, Double coordX, Double coordY) {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno registrarVuelo(Double coordXi, Double coordYi, Double coordXf, Double coordYf,
			int capacidad_paquetes, int costo, int tiempo_minutos) {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno reporteEnviosPorEmpresa() {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno reporteEnviosPorCliente() {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno reporteEnviosPendientesPorCliente() {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno enviarComprasUrgenteCliente(String cedula, int cant_paquetes) {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno enviarComprasEstandarCliente(String cedula, int cant_paquetes) {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}

	@Override
	public TipoRetorno mapaEstado() {
		// TODO Auto-generated method stub
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}
		
}
