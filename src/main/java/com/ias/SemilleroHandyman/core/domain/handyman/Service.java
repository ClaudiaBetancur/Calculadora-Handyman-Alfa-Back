package com.ias.SemilleroHandyman.core.domain.handyman;

public class Service {

    public final IdHandyman idHandyman;
    public final IdOperatorService idOperatorService;
    public final IdService idService;
    public final ServiceStar serviceStar;
    public final ServiceEnd serviceEnd;

    public Service(IdHandyman idHandyman, IdOperatorService idOperatorService, IdService idService, ServiceStar serviceStar, ServiceEnd serviceEnd) {
        this.idHandyman = idHandyman;
        this.idOperatorService = idOperatorService;
        this.idService = idService;
        this.serviceStar = serviceStar;
        this.serviceEnd = serviceEnd;
    }

    public IdHandyman getIdHandyman() {
        return idHandyman;
    }

    public IdOperatorService getIdOperatorService() {
        return idOperatorService;
    }

    public IdService getIdService() {
        return idService;
    }

    public ServiceStar getServiceStar() {
        return serviceStar;
    }

    public ServiceEnd getServiceEnd() {
        return serviceEnd;
    }
}


