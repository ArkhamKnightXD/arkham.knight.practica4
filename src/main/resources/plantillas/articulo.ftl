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
                        <span class="text-primary pb-3 px-3">
                            <i class="fas fa-hashtag"></i>
                            <#list articulo.listaEtiquetas as etiqueta>
                                <a href="/etiqueta/${etiqueta.id}">${etiqueta.etiqueta}</a>
                            </#list>
                        </span>
                    </#if>
                    <h5 class="col-12 pt-3">
                        <strong><i class="fas fa-eye"></i> REACCIONES</strong>
                        <hr noshade>
                    </h5>
                    <form action="/articulo/${articulo.id}/votar" method="post" class="mx-auto pb-3 pl-3">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="voto" value="Me gusta">
                            <label class="form-check-label" for="me-gusta">
                                <i class="fas fa-thumbs-up fa-2x" style="color: #0099ff" title="Me gusta"></i>
                                <span class="badge badge-secondary">${votosMeGusta}</span>
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="voto" value="Me encanta">
                            <label class="form-check-label" for="me-encanta">
                                <i class="fas fa-smile fa-2x" style="color: yellow" title="Me encanta"></i>
                                <span class="badge badge-secondary">${votosMeEncanta}</span>
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="voto" value="Meh">
                            <label class="form-check-label" for="meh">
                                <i class="fas fa-meh fa-2x" style="color: yellow" title="Meh"></i>
                                <span class="badge badge-secondary">${votosMeh}</span>
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="voto" value="Me disgusta">
                            <label class="form-check-label" for="me-disgusta">
                                <i class="fas fa-frown fa-2x" style="color: red" title="Me disgusta"></i>
                                <span class="badge badge-secondary">${votosMeDisgusta}</span>
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="voto" value="Me indigna">
                            <label class="form-check-label" for="me-indigna">
                                <i class="fas fa-poo fa-2x" style="color: saddlebrown" title="Me indigna"></i>
                                <span class="badge badge-secondary">${votosMeIndigna}</span>
                            </label>
                        </div>
                        <button type="submit" class="btn btn-outline-light">Reaccionar</button>
                        <br><br>
                        <#if votoActual??>
                            <p class="mb-0"><strong>Haz reaccionado con un:</strong> ${votoActual.voto}.</p>
                        <#else>
                            <strong>No olvides dejar tu voto.</strong>
                        </#if>
                    </form>
                </div>
            </div>
            <div class="card-footer p-2">
                <div class="col-12 mt-2 bg-dark px-4 rounded-0 login">
                    <div class="row">
                        <form class="col-11 py-5" method="post" action="/articulo/${articulo.id}/comentar">
                            <div class="panel px-2 py-3 bg-white">
                                <label for="comentario"><strong>Comentario</strong></label>
                                <textarea name="comentario" class="form-control rounded-0"></textarea>
                            </div>
                            <button class="btn btn-outline-light btn-block mt-3" type="submit">
                                COMENTAR
                            </button>
                        </form>
                    </div>
                    <div class="row">
                        <h5 class="col-12 pt-3">
                            <i class="fas fa-comments text-light">COMENTARIOS</i>
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
                                    <form action="/articulo/${comentario.id}/valorar" method="post"
                                          class="mx-auto pb-3 pl-3">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="valoracion" value="Me gusta">
                                            <label class="form-check-label" for="me-gusta">
                                                <i class="fas fa-thumbs-up fa-2x" style="color: #0099ff"
                                                   title="Me gusta"></i>
                                                <span class="badge badge-secondary">${comentario.cantidadMeGusta}</span>
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="valoracion"
                                                   value="Me encanta">
                                            <label class="form-check-label" for="me-encanta">
                                                <i class="fas fa-smile fa-2x" style="color: darkorange"
                                                   title="Me encanta"></i>
                                                <span class="badge badge-secondary">${comentario.cantidadMeEncanta}</span>
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="valoracion" value="Meh">
                                            <label class="form-check-label" for="meh">
                                                <i class="fas fa-meh fa-2x" style="color: darkorange" title="Meh"></i>
                                                <span class="badge badge-secondary">${comentario.cantidadMeh}</span>
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="valoracion"
                                                   value="Me disgusta">
                                            <label class="form-check-label" for="me-disgusta">
                                                <i class="fas fa-frown fa-2x" style="color: red" title="Me disgusta"></i>
                                                <span class="badge badge-secondary">${comentario.cantidadMeDisgusta}</span>
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="valoracion"
                                                   value="Me indigna">
                                            <label class="form-check-label" for="me-indigna">
                                                <i class="fas fa-poo fa-2x" style="color: saddlebrown"
                                                   title="Me indigna"></i>
                                                <span class="badge badge-secondary">${comentario.cantidadMeIndigna}</span>
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-outline-primary">Reaccionar</button>
                                    </form>
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