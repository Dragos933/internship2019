package Service;

import Exceptions.ValidatorException;
import Model.Distance.Distance;
import Repository.InMemoryRepository;

import java.util.Map;

public class DistanceService
{
    InMemoryRepository repo;

    public DistanceService(InMemoryRepository repo) {
        this.repo = repo;
    }

    public void add(Distance el) throws ValidatorException {
        this.repo.save(el);
    }

    public void delete(Integer id) throws ValidatorException
    {
        this.repo.delete(id);
    }

    public void update(Distance el) throws ValidatorException
    {
        this.repo.update(el);
    }

    public Distance find(Integer id)
    {
        return (Distance) this.repo.findOne(id);
    }

    public long size()
    {
        return this.repo.size();
    }

    public Map<Integer, Distance> getDistances()
    {
        return this.repo.getElements();
    }

}
