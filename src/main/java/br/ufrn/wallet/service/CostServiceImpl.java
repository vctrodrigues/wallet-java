package br.ufrn.wallet.service;

import org.springframework.stereotype.Component;

@Component
public class CostServiceImpl {
    
    @Autowired
    CostRepository costRepository;

    @Override
    public Cost createCost(Cost cost) {
        return costRepository.save(cost);
    }

    @Override
    public void deleteCost(Cost cost) {
        return costRepository.delete(cost);
    }

    @Override
    public Cost getCostById(Integer id) {
        return costRepository.findById(id).map(cost -> {
            return cost;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Cost> getListCost() {
        return costRepository.findAll();
    }

}
