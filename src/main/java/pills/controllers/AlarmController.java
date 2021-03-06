package pills.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;
import pills.models.AddAlarmModel;
import pills.models.AlarmModel;
import pills.models.ReminderModel;
import pills.models.UserAlarmModel;
import pills.service.AlarmService;

@RestController
@RequestMapping(value = "/alarms")
public class AlarmController {

  @Autowired
  private AlarmService alarmService;


  /**
   * Lists all the alarms from database
   * 
   * @return List of AlarmModel
   * @throws BadRequestException Thrown when there is exception in database
   */
  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<AlarmModel> viewAll() throws BadRequestException {
    return alarmService.viewAll();
  }

  /**
   * @param alarm {@link AddAlarmModel} details of the alarm to be added
   * @return AlarmModel
   * @throws BadRequestException Thrown when there is exception in database
   */
  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public AlarmModel create(@RequestBody AddAlarmModel alarm) throws BadRequestException {
    System.out.println(alarm.getAPillId() + "" + alarm.getARecurrence());
    // return null;
    return alarmService.addAlarm(alarm);
  }

  /**
   * @param id Id of the alarm to be viewed
   * @return UserAlarmModel
   * @throws NotFoundException Thrown when there is no alarm is found for particular id
   * @throws BadRequestException Thrown when there is exception in database
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public UserAlarmModel view(@PathVariable Integer id)
      throws NotFoundException, BadRequestException {
    return alarmService.viewAlarm(id);
  }

  /**
   * @param alarm {@link AlarmModel}
   * @return AlarmModel
   * @throws BadRequestException Thrown when there is exception in database
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
  @ResponseStatus(HttpStatus.OK)
  public AlarmModel update(@RequestBody AlarmModel alarm) throws BadRequestException {
    alarmService.updateAlarm(alarm);
    return alarm;
  }

  /**
   * @param id Id of the alarm to be deleted
   * @throws NotFoundException Thrown when there is no object with given id
   * @throws BadRequestException Thrown when there is exception in database
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Integer id) throws NotFoundException, BadRequestException {
    alarmService.deleteAlarm(id);
  }

  /**
   * 
   * @return List of {@link ReminderModel}
   * @throws BadRequestException Thrown when there is exception in database
   */
  @RequestMapping(value = "/reminders", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<ReminderModel> view() throws BadRequestException {
    return alarmService.getByRecurrence(1);
  }
}
