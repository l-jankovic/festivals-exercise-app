import Axios from "../../apis/Axios"
import { Button, Col, Row } from "react-bootstrap"
import { Role } from "../../services/auth";



const ShowConcerts=(props)=>{


    const deleteConcert = (concertId) => {

   
        
            Axios.delete("/nastupi/" + concertId)
            .then(res => {
               
                console.log(res);
                alert("Concert was deleted was deleted")
                 window.location.reload();
              
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })

    }





   

//Ako  ne iniciramo u stateu nista onda Movie && Movie.naziv da ne bi pucalo null, tako za svaki parametar
  return (
           <tr>
             <td>{props.concert.imeIzvodjaca}</td>
            <td>{props.concert.nazivFestivala}</td>
            {Role()=='isAdmin'&&
           <td><Button className="btn btn-danger" onClick={() => deleteConcert(props.concert.id)}>Delete</Button></td>
            }
        </tr>
    )





















}


export default ShowConcerts;