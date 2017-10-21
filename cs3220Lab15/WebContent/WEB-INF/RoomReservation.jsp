<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Reservation</title>
</head>
<body>
<p>Room Reservations for E&T A309</p>
<table border="1">
  <tr>
  	<th></th><th> MON </th><th> TUE </th><th> WED </th><th> THR </th><th> FRI </th>
  </tr>
  <c:forEach items="${entries}" var="entry">
  <tr>
    <td>8:00-9:00</td>
    <td><c:if test="${entry.time == '8:00-9:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '8:00-9:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '8:00-9:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '8:00-9:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '8:00-9:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  <tr>
    <td>9:00-10:00</td>
    <td><c:if test="${entry.time == '9:00-10:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '9:00-10:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '9:00-10:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '9:00-10:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '9:00-10:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  <tr>
    <td>10:00-11:00</td>
    <td><c:if test="${entry.time == '10:00-11:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '10:00-11:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '10:00-11:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '10:00-11:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '10:00-11:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  <tr>
    <td>11:00-12:00</td>
    <td><c:if test="${entry.time == '11:00-12:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '11:00-12:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '11:00-12:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '11:00-12:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '11:00-12:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  <tr>
    <td>12:00-13:00</td>
    <td><c:if test="${entry.time == '12:00-13:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '12:00-13:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '12:00-13:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '12:00-13:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '12:00-13:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  <tr>
    <td>13:00-14:00</td>
    <td><c:if test="${entry.time == '13:00-14:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '13:00-14:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '13:00-14:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '13:00-14:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '13:00-14:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  <tr>
    <td>14:00-15:00</td>
    <td><c:if test="${entry.time == '14:00-15:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '14:00-15:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '14:00-15:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '14:00-15:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '14:00-15:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  <tr>
    <td>15:00-16:00</td>
    <td><c:if test="${entry.time == '15:00-16:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '15:00-16:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '15:00-16:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '15:00-16:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '15:00-16:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  <tr>
    <td>16:00-17:00</td>
    <td><c:if test="${entry.time == '16:00-17:00' && entry.day == 'MON' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '16:00-17:00' && entry.day == 'TUE' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '16:00-17:00' && entry.day == 'WED' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '16:00-17:00' && entry.day == 'THR' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
    <td><c:if test="${entry.time == '16:00-17:00' && entry.day == 'FRI' }"><a href="DeleteReservation">${entry.name}</a></c:if></td>
  </tr>
  </c:forEach>
  </table>
  <br>
  
  
  <form id="Reserve" action="RoomReservation" method="get">
  		<select name='day'>
			<option>MON</option>
			<option>TUE</option>
			<option>WED</option>
			<option>THR</option>
			<option>FRI</option>
		</select>
		
		<select name='time'>
			<option>8:00-9:00</option>
			<option>9:00-10:00</option>
			<option>10:00-11:00</option>
			<option>11:00-12:00</option>
			<option>12:00-13:00</option>
			<option>13:00-14:00</option>
			<option>14:00-15:00</option>
			<option>15:00-16:00</option>
			<option>16:00-17:00</option>
		</select>
		
		<input type='text' name='name' />
		
		<button type="submit" form="Reserve" value="Submit">Reserve</button>
	</form>
</body>
</html>