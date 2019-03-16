<#import "/plantillas/base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=nombreUsuario permisos=tienePermisos admin=esAdmin>
<div class="col-12 p-2">
    <div class="row">
        <#list articulos as articulo>
            <div class="col-6 mx-auto p-0">
                <div class="card mx-2 mb-5">
                    <div class="card-body">
                        <h5 class="card-title text-primary">${articulo.titulo}</h5>
                        <p class="card-text text-primary  m-0 cuerpo-corto">${articulo.cuerpoCorto}</p>
                        <a href="/articulo/${articulo.id}" class="text-primary float-right"><strong>Ver mas</strong></a>
                    </div>
                    <div class="card-footer p-2 bg-dark">
                        <strong class="text-danger m-0">
                            <span class="text-primary">
                                <i class="fas fa-calendar-check-o"></i> ${articulo.fecha}
                            </span>
                            <span class="text-light ml-5">
                                <i class="fas fa-comments"></i> ${articulo.listaComentarios?size}
                            </span>
                            <#if articulo.listaEtiquetas?size gt 0>
                                <span class="text-primary ml-5">
                                    <i class="fas fa-hashtag"></i>
                                    <#list articulo.listaEtiquetas as etiqueta>
                                        <a href="/etiqueta/${etiqueta.id}">${etiqueta.etiqueta}</a>
                                    </#list>
                                </span>
                            </#if>
                        </strong>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
    <div class="col">
        <div class="row">
            <nav>
                <ul class="pagination">
                    <#if paginaActual gt 1>
                        <li class="page-item">
                            <a class="page-link" href="/inicio/${paginaActual - 1}" aria-label="Anterior">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Anterior</span>
                            </a>
                        </li>
                    <#else>
                        <li class="page-item disabled">
                            <a class="page-link" href="/inicio/${paginaActual - 1}" aria-label="Anterior">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Anterior</span>
                            </a>
                        </li>
                    </#if>
                    <#if paginaMaxima gt paginaActual>
                        <li class="page-item">
                            <a class="page-link" href="/inicio/${paginaActual + 1}" aria-label="Siguiente">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Siguiente</span>
                            </a>
                        </li>
                    <#else>
                        <li class="page-item disabled">
                            <a class="page-link" href="/inicio/${paginaActual + 1}" aria-label="Siguiente">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Siguiente</span>
                            </a>
                        </li>
                    </#if>
                </ul>
            </nav>
        </div>
    </div>
</@base.pagina>