<#import "/plantillas/base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=nombreUsuario permisos=tienePermisos admin=esAdmin>
<div class="col-12 p-2">
    <div class="row">
        <div class="card col-10 mx-auto p-0">
            <div class="card-body">
                <h5 class="card-title text-primary">
                    ${articulo.titulo}
                    <strong class=" m-0 float-right">
                        <#if tienePermisos>
                            <a href="/articulo/editar/${articulo.id}" class="text-primary ml-2">
                                <i class="fas fa-edit"></i> Editar articulo
                            </a>
                            <a href="/articulo/eliminar/${articulo.id}" class="text-danger ml-2">
                                <i class="fas fa-minus-circle"></i> Eliminar articulo
                            </a>
                        </#if>
                    </strong>
                </h5>
                <p class="card-text text-primary m-0">${articulo.cuerpo}</p>
            </div>
            <div class="col-12 mt-2 bg-dark text-light px-4 rounded-0 login">
                <div class="row">
                    <h5 class="col-12 pt-3">
                        <strong>ETIQUETAS</strong>
                        <hr noshade>
                    </h5>
                        <#if articulo.listaEtiquetas?size gt 0>
                            <span class="text-light pb-3 px-3">
                                <i class="fas fa-hashtag"></i>
                                <#list articulo.listaEtiquetas as etiqueta>
                                    ${etiqueta.etiqueta}
                                </#list>
                            </span>
                        </#if>
                </div>
            </div>
            <div class="card-footer p-2">
                <div class="col-12 mt-2 bg-light px-4 rounded-0 login">
                    <div class="row">
                        <form class="col-11 py-5" method="post" action="/articulo/${articulo.id}/comentar">
                            <div class="panel px-2 py-3 bg-white">
                                <label for="comentario"><strong>Comentario</strong></label>
                                <textarea name="comentario" class="form-control rounded-0"></textarea>
                            </div>
                            <button class="btn btn-outline-primary btn-block my-3" type="submit">
                                COMENTAR
                            </button>
                        </form>
                                            </div>
                </div>
                <div class="col-12 mt-2 bg-dark text-light px-4 rounded-0 login">
                    <div class="row">
                        <h5 class="col-12 pt-3">
                            <strong>COMENTARIOS</strong>
                            <hr noshade>
                        </h5>
                        <#list articulo.listaComentarios as comentario>
                        <div class="card col-12 mb-1 p-0">
                            <div class="card-body">
                                <h5 class="card-title m-0">
                                    <strong>
                                        <i class="fas fa-user"></i> ${comentario.autor.username}
                                    </strong>
                                </h5>
                            </div>
                            <div class="card-footer p-2">
                                <strong class="text-primary m-0">
                                    <i class="far fa-comment"></i> ${comentario.comentario}
                                </strong>
                            </div>
                        </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</@base.pagina>