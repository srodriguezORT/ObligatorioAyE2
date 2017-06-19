package obligaye2;

import obligaye2.ISistema;
import obligaye2.TipoRetorno.TipoError;


public class Sistema implements ISistema {
    
    int cantMaxCiu;
    Lista<Cliente> clientes;
    Lista<Ciudad> ciudades;
    Lista<Vuelo> vuelos;
    Lista<Compra> compras;
    Lista<Empresa> empresas;

	@Override
	public TipoRetorno inicializarSistema(int cantCiudadesMax, Double CoordXDestino, Double CoordYDestino,
            String nombreCiudadDestino, Double CoordXOrigen, Double CoordYOrigen, String nombreCiudadOrigen) {
            if(cantCiudadesMax < 2){
                return new TipoRetorno(TipoError.ERROR_1);
            }else if (nombreCiudadDestino.equals("") || nombreCiudadOrigen.equals("")){
                return new TipoRetorno(TipoError.ERROR_2);
            }
            cantMaxCiu = cantCiudadesMax;
            ciudades = new Lista<>();
            clientes = new Lista<>();
            vuelos = new Lista<>();
            compras = new Lista<>();
            empresas = new Lista<>();
            ciudades.agregarFin(new Ciudad(nombreCiudadDestino, CoordXDestino, CoordYDestino));
            ciudades.agregarFin(new Ciudad(nombreCiudadOrigen, CoordXOrigen, CoordYOrigen));
            return new TipoRetorno(TipoError.OK);
	}

	@Override
	public TipoRetorno destruirSistema() {
		ciudades = null;
                clientes = null;
                vuelos = null;
                compras = null;
                empresas = null;
		return new TipoRetorno(TipoError.OK);
	}

	@Override
	public TipoRetorno registrarCliente(String cedula, String nombre, String direccion, String email) {
		
            Cliente aux = new Cliente(cedula);
            if(!Cliente.esValidaCi(cedula)){
                return new TipoRetorno(TipoError.ERROR_1);
            }else if(!Cliente.esValidoEmail(email)){
                return new TipoRetorno(TipoError.ERROR_2);
            }else if(clientes.existe(aux)){
            return new TipoRetorno(TipoError.ERROR_3);
            }
            
            clientes.agregarInicio(new Cliente(cedula, nombre, direccion, email));
            return new TipoRetorno(TipoError.OK);
            
	}

	@Override
	public TipoRetorno registrarCompra(String cedula, int trackingId, String empresa) {
		
            Cliente auxCli = new Cliente(cedula);
            Compra auxCom = new Compra(trackingId,empresa);
            Empresa auxE = new Empresa(empresa);
            if(clientes.existe(auxCli)){
                return new TipoRetorno(TipoError.ERROR_1);
            }
            
            if(!empresas.existe(auxE))
            {
                empresas.agregarFin(auxE);
            }
            clientes.buscar(auxCli).getCompras().agregarFin(auxCom);
            compras.agregarFin(auxCom);
            empresas.buscar(auxE).setCantCompras(empresas.buscar(auxE).getCantCompras() + 1);
            return new TipoRetorno(TipoError.OK);
	}

	@Override
	public TipoRetorno registrarCiudad(String Nombre, Double coordX, Double coordY) {
		
            Ciudad aux = new Ciudad(coordX, coordY);
            if(ciudades.getSize() == cantMaxCiu){
                return new TipoRetorno(TipoError.ERROR_1);
            }else if(Nombre.equals("")){
                return new TipoRetorno(TipoError.ERROR_2);
            }else if(ciudades.existe(aux)){
            return new TipoRetorno(TipoError.ERROR_3);
            }
            
            ciudades.agregarInicio(new Ciudad(Nombre, coordX, coordY));
            return new TipoRetorno(TipoError.OK);
	}

	@Override
	public TipoRetorno registrarVuelo(Double coordXi, Double coordYi, Double coordXf, Double coordYf,
			int capacidad_paquetes, int costo, int tiempo_minutos) {
		
            Ciudad auxO = new Ciudad(coordXi, coordYi);
            Ciudad auxD = new Ciudad(coordXf, coordYf);
            Vuelo auxV = new Vuelo(coordXi, coordYi, coordXf, coordYf);
            if(capacidad_paquetes <= 0){
                return new TipoRetorno(TipoError.ERROR_1);
            }else if(costo <= 0){
                return new TipoRetorno(TipoError.ERROR_2);
            }else if(tiempo_minutos <= 0){
            return new TipoRetorno(TipoError.ERROR_3);
            }else if(!ciudades.existe(auxO) || !ciudades.existe(auxD)){
            return new TipoRetorno(TipoError.ERROR_4);
            }else if(vuelos.existe(auxV)){
            return new TipoRetorno(TipoError.ERROR_5);
            }
            
            vuelos.agregarFin(new Vuelo(coordXi, coordYi, coordXf, coordYf, capacidad_paquetes, costo, tiempo_minutos));
            return new TipoRetorno(TipoError.OK);
	}

	@Override
	public TipoRetorno reporteEnviosPorEmpresa() {
		
            String valor = "";
                for (Empresa x : empresas) {
                
                    valor += x.getNombre() +";"+ x.getCantCompras()+"|";
            }
                valor = valor.substring(0, valor.length()-2);
		return new TipoRetorno(valor);
	}

	@Override
	public TipoRetorno reporteEnviosPorCliente() {
		
            String valor = "";
            int cant = 0;
                for (Cliente x : clientes) {
                
                   for (Compra c : x.getCompras())
                   {
                       if(c.isEnviado())
                       {
                           cant++;
                       }
                   }
                   
                   valor += x.getNombreCliente() +";"+ cant+"|";
            }
                
                valor = valor.substring(0, valor.length()-2);
		return new TipoRetorno(valor);
	}

	@Override
	public TipoRetorno reporteEnviosPendientesPorCliente() {
		String valor = "";
                String ids = "";
                for (Cliente x : clientes) {
                
                   for (Compra c : x.getCompras())
                   {
                       if(!c.isEnviado())
                       {
                           ids += c.getTrackingId() + ";";
                       }
                   }
                   ids = ids.substring(0, ids.length()-2);
                   valor += x.getNombreCliente() +";"+ ids+"|";
            }
                
                valor = valor.substring(0, valor.length()-2);
		return new TipoRetorno(valor);
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
		String URL = 
         "https://maps.googleapis.com/maps/api/staticmap?center=Australia&size=640x400&style=element:labels|"
                        + "visibility:off&style=element:geometry.stroke|visibility:off&style=feature:landscape|"
                        + "element:geometry|saturation:-100&style=feature:water|saturation:-100|"
                        + "invert_lightness:true&key=AIzaSyDhfTvXeR1_KtzXelJWoMu64w9RaZ7bmE8";
		return new TipoRetorno(TipoError.NO_IMPLEMENTADA);
	}
		
}
