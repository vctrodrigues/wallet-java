package br.ufrn.wallet.service;

import org.springframework.stereotype.Component;

@Component
public class MoneyBoxServiceImpl {
    
    @Autowired
    MoneyBoxRepository moneyBoxRepository;

    @Override
    public MoneyBox createMoneyBox(MoneyBox moneyBox) {
        return moneyBoxRepository.save(moneyBox);
    }

    @Override
    public void deleteMoneyBox(MoneyBox moneyBox) {
        return moneyBoxRepository.delete(moneyBox);
    }

    @Override
    public User getMoneyBoxById(Integer id) {
        return moneyBoxRepository.findById(id).map(moneyBox -> {
            return moneyBox;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<MoneyBox> getListMoneyBox() {
        return moneyBoxRepository.findAll();
    }

}
