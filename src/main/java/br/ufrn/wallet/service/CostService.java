package br.ufrn.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface CostService {
    
    public Cost createCost(Cost cost);
    public void deleteCost(Cost cost);
    public Cost getCostById(Integer id);
    public List<Cost> getListCost();

}
