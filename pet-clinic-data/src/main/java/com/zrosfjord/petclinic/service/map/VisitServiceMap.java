package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.Visit;
import com.zrosfjord.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map"})
public class VisitServiceMap extends AbstractMapService<Visit> implements VisitService {
}
